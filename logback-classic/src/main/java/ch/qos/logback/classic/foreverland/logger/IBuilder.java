package ch.qos.logback.classic.foreverland.logger;

/**
 * @author Thud
 * @date 2022/11/9
 */
public interface IBuilder {
    IBuilder of(String k ,String v);

    String builderMsg(String msg);
}
