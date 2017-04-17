package com.noway.avro.server.connect;

import com.noway.avro.server.proto.AvroRequestProto;
import com.noway.avro.server.proto.AvroRequestProtoServer;
import com.noway.avro.server.tools.CommonConfig;
import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.specific.SpecificResponder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by ziqing.chen
 * on 2017/4/17.
 */
public class AvroRpcServer {

    private static final Log LOGGER = LogFactory.getLog( AvroRpcServer.class.getName() );

    private static Server server;

    public static void startServer() throws IOException {
        startServer( Integer.valueOf( CommonConfig.defaultAvroPort ) );
    }

    public static void startServer( int port ) throws IOException {
        server = new NettyServer( new SpecificResponder( AvroRequestProto.class, new AvroRequestProtoServer() ), new InetSocketAddress( port ) );
        LOGGER.info( "avro Netty Server Started @ " + port );
    }

}
