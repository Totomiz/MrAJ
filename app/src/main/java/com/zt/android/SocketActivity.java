package com.zt.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.Socket;

public class SocketActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SocketActivity";
    private Button btnConn;
    private Button btnSend;
    private TextView tvShow;
    private EditText editText;
    private static final String SOCKET_IP = "192.168.1.106";
    private static final int PORT = 12345;
    private Handler handler;
    private Chart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);
        btnConn = (Button) findViewById(R.id.btnconn);
        btnSend = (Button) findViewById(R.id.btn_send);
        tvShow = (TextView) findViewById(R.id.tv);
        editText = (EditText) findViewById(R.id.edit_message);
        btnConn.setOnClickListener(this);
        btnSend.setOnClickListener(this);
        handler = new Handler();
        chart = new Chart(new WeakReference<Context>(SocketActivity.this));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnconn: {
                ConnectionThread connectionThread = new ConnectionThread(chart);
                connectionThread.start();
                break;
            }
            case R.id.btn_send: {
                String s = editText.getText().toString();
                Log.d(TAG, "onClick: "+"send"+s);
                SendMessageThread sm=new SendMessageThread(chart,s);
                sm.start();
                break;
            }
            default:
                break;
        }
    }

    private static class Chart {
        private static Socket socket;
        private boolean isConnected;
        private BufferedReader sin;
        private PrintWriter pw;
        private WeakReference<Context> ctx;
        public Chart(WeakReference<Context> ctx){
            this.ctx=ctx;
        }

        public void connectServer() {
            try {
                InetAddress localAdd = InetAddress.getLocalHost();
                Log.d(TAG, "local address : " + localAdd);
                InetAddress serverAddress = InetAddress.getByName(SOCKET_IP);
                socket = new Socket(serverAddress, PORT);
                isConnected = socket.isConnected();
                Log.d(TAG, "connectServer: "+isConnected);
                Log.d(TAG, "connectServer: "+socket.isInputShutdown());
                Log.d(TAG, "connectServer: "+socket.isOutputShutdown());
                Log.d(TAG, "connectServer: "+socket.isOutputShutdown());
            } catch (IOException e) {
                e.printStackTrace();
                Log.d(TAG, "", e);
            }
        }

        public String sendMessage(String s) {

            if(socket!=null){
                if(!socket.isClosed()&&socket.isConnected()) {
                    try {
                        Log.d(TAG, "sendMessage: " + s);
                        sin = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(s.getBytes())));
                        if (pw == null) {
                            pw = new PrintWriter(socket.getOutputStream());
                        }
                        if ((sin.readLine()) != null) {
                            pw.println(s);
                            pw.flush();
                        }
                        sin.close();
                        if (socket.isClosed()) {
                            pw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                if(ctx.get()!=null){
                    Toast.makeText(ctx.get(),"socket 已经关闭！",Toast.LENGTH_SHORT).show();
                }
            }

            return null;
        }
    }

    private static class SendMessageThread extends Thread{
        private Chart chart;
        private String message;
        public SendMessageThread(Chart chart,String message) {
            this.chart = chart;
            this.message=message;
        }

        @Override
        public void run() {
            chart.sendMessage(message);
        }
    }

    private static class ConnectionThread extends Thread {
        private Chart chart;

        public ConnectionThread(Chart chart) {
            this.chart = chart;
        }


        @Override
        public void run() {
            Log.d(TAG, "run: ");
            chart.connectServer();
        }
    }
}
