package com.example.tender.communication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.tender.activities.MainActivity;
import com.example.tender.entities.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketClient {
    private final Context context;
    private BufferedReader reader;
    private PrintWriter writer;
    private Socket socket;

    public SocketClient(Context context) {
        this.context = context;
    }

    private void initSocket() {
        if(socket == null) {
            try {
                InetAddress serverAddress = InetAddress.getByName("MOdificare ip");//modificare ip
                socket = new Socket();
                SocketAddress socketAddress = new InetSocketAddress(serverAddress,8080);
                socket.connect(socketAddress,2000);
                writer = new PrintWriter(socket.getOutputStream(),true);
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "connessione al server fallita", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);
                    }
                });
            }
        }
    }
    public String getUsernameFromPreferences() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("info",Context.MODE_PRIVATE);
        return sharedPreferences.getString("username","UTENTE");
    }

    private void sendUsername() {
        String username = getUsernameFromPreferences();
        writer.println(username);
    }

    private boolean checkResponseOK() {
        String response = "";
        try {
            response = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.equals("ok");
    }

    public boolean checkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null;
    }

    public void richiestaRegistrazione() {
        String REGISTRAZIONE = "registrazione";
        writer.println(REGISTRAZIONE);
    }
    public void richiestaLogin() {
        String LOGIN = "login";
        writer.println(LOGIN);
    }

    public void richiestaHomepage() {
        String HOMEPAGE = "homepage";
        writer.println(HOMEPAGE);
    }

    public void richiestaAcquista() {
        String ACQUISTA = "acquista";
        writer.println(ACQUISTA);
    }

    public void richiestaAggiungiDenaro() {
        String AGGIUNGI_DENARO = "AggiungiDenaro";
        writer.println(AGGIUNGI_DENARO);
    }

    public void startAggiungiDenaro(double denaro){
        Runnable addMoneyThread = () -> {
            initSocket();
            if(socket.isConnected()){
                sendUsername();
                if(checkResponseOK()){
                    richiestaAggiungiDenaro();
                    if(checkResponseOK()){
                        writer.println(getUsernameFromPreferences() + ";" + denaro);
                    }
                }
            }
            socket = null;
        };
        new Thread(addMoneyThread).start();
    }

    public void startRegistrazione(User user){
        Runnable registration = () ->{
            initSocket();
            if(socket.isConnected()){
                writer.println(user.getUsername());
                if(checkResponseOK()){
                    richiestaRegistrazione();
                    if(checkResponseOK()) {
                        writer.println(user.getUsername() + ";" + user.getPassword() + ";" + user.getPortafoglio());
                        if (checkResponseOK()) {
                            //avvenuta registrazione;
                        }
                    }
                }
            }
            socket=null;
        };
        new Thread(registration).start();
    }

    public void startLogin(User user,int[] flag){
        Runnable login = () -> {
            initSocket();
            if(socket.isConnected()){
                writer.println(user.getUsername());
                if(checkResponseOK()) {
                    richiestaLogin();
                    if (checkResponseOK()) {
                        writer.println(user.getUsername()+";"+user.getUsername() + ";" + user.getPassword());
                        if (checkResponseOK()) {
                            flag[0]=1;
                        }
                    }
                }
            }
            socket=null;
        };
        new Thread(login).start();

    }
/*
    private final Runnable buyThread = () -> {
        initSocket();
        if(socket.isConnected()){
            sendUsername();
            if (checkResponseOK()){
                richiestaAcquista();
                if (checkResponseOK()){
                    //send totale di acquisto
                }
            }
        }
        socket = null;
    };

 */
}
