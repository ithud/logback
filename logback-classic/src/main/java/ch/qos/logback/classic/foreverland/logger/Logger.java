package ch.qos.logback.classic.foreverland.logger;

/**
 * @author Thud
 * @date 2022/11/9
 */
public interface Logger {
    void info(IBuilder builder,String format ,Object... argArray);
}
