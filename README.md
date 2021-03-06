# basicToyProject
사이드 프로젝트로 Spring Boot+ JPA + 타임리프 스터디

엔티티 설계시 주의점
1. 엔티티에는 가급적 Setter를 사용하지 말자
2. 모든 연관관계는 지연로딩으로 설정(꼭) N+1문제
   1. 즉시 로딩(EAGER)
      1. 
   2. 지연 로딩(LAZY)
      1. asd
   3. Fetch Join
   4. ManyToOne은 LAZY로 바꾸자
3. 컬렉션은 필드에서 초기화 하자.
4. Lazy로딩으로 기본으로 하고, 성능 최적화가 필요한 경우에는 패치 조인을 사용
5. 1+N 인 상황에서는 Fetch Join으로 해결 하자(100% 반드시 이해해야 된다.)
6. JPA Distinct
   1. DB의 키워드 Distinct + 엔티티의 중복을 걸러서 컬렉션을 담아준다.
7. QueryDSL
   1. JPA Creteria 대신 사용 할 수 있는 거 대체 할 수 있는 이유는 동적 쿼리를 작성할때 [유지보수가 힘들며 버그가 나올 수 있는 상황이 너무 뻔하다.]
8. 참고 
/**

* JoinTable
* 관계형 DB는 1 대 다 다 대 1로 필요하기 때무네 중간 테이블이 있어야 된다.
* 객체에는 컬렉션이 있어서 1대 다 다 대 1이 가능 한데 Category Item은 관계형 DB이기 때문이다.
* 
* Category 계층형 구조
* @Getter는 열어 놓고
* @Setter는 변경이 일어날 객체에 지정 해도록 하자.
* 실무에서는 @ManyToMany를 사용하지 말자.
* 생성자는 Protected로 설정을 하여서 값을 모두 초기화 하고 변경 불가능한 클래스로 만드는게  좋다.
  */
