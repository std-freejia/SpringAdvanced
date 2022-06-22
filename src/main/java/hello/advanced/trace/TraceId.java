package hello.advanced.trace;

import java.util.UUID;

public class TraceId {

    private String id; // 트랜젝션 아이디
    private int level; // 메서드 호출 시 깊이

    public TraceId(){ // 기본 생성
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level){
        this.id = id;
        this.level = level;
    }

    private String createId(){ // UUID 생성하여 앞에 8개만 잘라서 쓸것임.
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextId(){ // 트랜젝션이 메서드 호출 시, 깊이 증가
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId(){ // 깊이 감소
        return new TraceId(id, level - 1 );
    }

    public boolean isFirstLevel(){
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
