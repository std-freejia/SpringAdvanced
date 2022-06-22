package hello.advanced.trace;

public class TraceStatus {

    private TraceId traceId; // 트랜젝션ID와 깊이
    private Long startTime;  // 로그 시작시간
    private String message;  // 로그 시작시 사용한 메시지

    public TraceStatus(TraceId traceId, Long startTime, String message) {
        this.traceId = traceId;
        this.startTime = startTime;
        this.message = message;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public String getMessage() {
        return message;
    }
}
