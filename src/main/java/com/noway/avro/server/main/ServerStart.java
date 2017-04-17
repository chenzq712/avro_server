package com.noway.avro.server.main;

import com.noway.avro.server.connect.AvroRpcServer;

import java.io.IOException;

/**
 * Created by ziqing.chen
 * on 2017/4/17.
 */
public class ServerStart {

    public static void main( String[] args ) {
        try {
            AvroRpcServer.startServer( 40012 );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

}
