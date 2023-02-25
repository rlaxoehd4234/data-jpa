package study.datajpa.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name" , "age"})
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")// pk 값은 jpa 가 알아서 정해준다.
    private Long id;
    private String name;
    private int age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String userName){
        this.name = userName;
    }

    public Member(String memberName, int age, Team team) {
        this.name = memberName;
        this.age = age;

        if( team != null){
            changeTeam(team);
        }
    }

    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }


}
