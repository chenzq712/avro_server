package com.noway.avro.server.proto;

import com.noway.avro.server.tools.CodeEnum;
import org.apache.avro.util.Utf8;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ziqing.chen
 * on 2017/4/17.
 */
public class AvroRequestProtoServer implements AvroRequestProto {

    private static final Log LOGGER = LogFactory.getLog( AvroRequestProtoServer.class.getName() );

    @Override
    public Utf8 send( Message message ) {
        LOGGER.info( "接收到" + message.getRequestName() + "请求" );
        if ( message.getRequestName() == null || message.getRequestName().length() <= 0 ) {
            LOGGER.error( "RequestName参数不正确" );
            return new Utf8( "\"note\":\"SUCCESS\",\"code\":10200,\"success\":true" );
        }
        Map< String, Object > response = new HashMap< String, Object >();
        response.put( "id", "1234" );
        response.put( "name", "test" );
        LOGGER.info( message.getRequestName() + "--- requestName" );
        return new Utf8( "\"note\":\"SUCCESS\",\"code\":10200,\"success\":true" );
    }
}
