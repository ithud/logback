package ch.qos.logback.classic.foreverland.logger;

import ch.qos.logback.core.util.StringCollectionUtil;
import com.alibaba.ttl.TransmittableThreadLocal;
import org.apache.commons.lang3.StringUtils;
import org.graalvm.util.CollectionsUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Thud
 * @date 2022/11/9
 */
public class LoggerEvent {
    private static final  String TRACE_ID = "TRACE_ID";
    private static TransmittableThreadLocal<Map<String,String>> context = new TransmittableThreadLocal<>();

    public static Map<String,String> getContext(){
        Map<String,String> content = context.get();
        if(null == content){
            setTrace("");
            //reload
            content = context.get();
        }
        return content;
    }

    public static String getTrace() {
        Map<String,String> trace = context.get();

        if(null == trace || trace.size() == 0){

            return setTrace("");
        }
        return trace.get(TRACE_ID);
    }

    public static String setTrace(String callType) {
        Map<String,String> trace = context.get();
        if(null == trace){
            trace = new HashMap<>();
        }
        //existed trace id
        if(!StringUtils.isEmpty(trace.get(TRACE_ID))){
            return trace.get(TRACE_ID);
        }
        //create trace id
        String traceId = !StringUtils.isEmpty(callType)
                ?callType+"-"+UUID.randomUUID()
                :"Other"+"-"+UUID.randomUUID();

        trace.put(TRACE_ID,traceId);
        context.set(trace);
        return traceId;
    }

}
