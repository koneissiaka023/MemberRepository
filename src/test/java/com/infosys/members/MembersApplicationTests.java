package com.infosys.members;


import com.infosys.members.members.MemberRepository;
import com.infosys.members.members.Members;
import com.infosys.members.members.MembersService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.mockito.Mockito.*;


@SpringBootTest
class MembersApplicationTests {
	@Mock
	private MemberRepository memberRepository;
	@Autowired
	@InjectMocks
	private MembersService membersService;
	private Members memb;
	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void seUp(){
		memb = new Members(1, "bob", "john", "email@mail.com", 1, "888-888-8888", "123 msin street");
	}

	@AfterEach
	public void teardown(){
		memb = null;
	}

	@Test
	public void testingMemberRegister(){
		when(memberRepository.save(any())).thenReturn(memb);
		membersService.saveMember(memb);
		verify(memberRepository, times(1)).save(any());
	}
}
