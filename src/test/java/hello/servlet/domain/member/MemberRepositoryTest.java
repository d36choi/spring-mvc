package hello.servlet.domain.member;


import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

  private MemberRepository memberRepository = MemberRepository.getInstance();

  @AfterEach
  void afterEach() {
    memberRepository.clearStore();
  }

  @Test
  void save() {

    //given
    Member member = new Member("choi",26);

    //when
    Member savedMember = memberRepository.save(member);
    //then
    Assertions.assertThat(savedMember).isEqualTo(member);
  }

  @Test
  void findAll() {
    //given
    Member member1 = new Member("kim",12);
    Member member2 = new Member("Lee",32);
    //when

    final Member savedMember1 = memberRepository.save(member1);
    final Member savedMember2 = memberRepository.save(member2);
    final List<Member> members = Arrays.asList(savedMember1, savedMember2);
    //then
    Assertions.assertThat(memberRepository.findAll()).isEqualTo(members);
  }
}