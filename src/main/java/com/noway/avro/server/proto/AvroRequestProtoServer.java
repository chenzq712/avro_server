package com.noway.avro.server.proto;

import com.infogen.core.json.Return;
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
            Return ret = Return.FAIL( CodeEnum.AVRO_PARAMETERS_INCORRECT.code, CodeEnum.AVRO_PARAMETERS_INCORRECT.name() );
            return new Utf8( ret.toJson() );
        }
        Map<String, Object> response = new HashMap<String, Object>();
        response.put( "id", "1234" );
        response.put( "name", "test" );
//        String response = "\"id\":\"123\",\"name\":\"test\"";
        LOGGER.info( message.getRequestName() + "--- requestName" );
        Return ret = Return.SUCCESS( CodeEnum.SUCCESS.code, CodeEnum.SUCCESS.name() ).put( "data", response );
        return new Utf8( ret.toJson() );
    }
}
