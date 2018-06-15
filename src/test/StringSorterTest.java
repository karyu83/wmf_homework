package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import main.StringSorter;
import main.UnExpectedInputException;

public class StringSorterTest {
	
	public StringSorterTest(){
		
	}
	
	private StringSorter ss;
	
	// 클래스 초기화
	@Before
	public void setUp(){
		this.ss = new StringSorter();
	}
	
	// 입력된 문자열 그대로 반환 가능한지 여부 테스트
	@Test
	public void inputTest() {
		
		assertThat(ss.sorter("1111"),is("1111"));
		assertThat(ss.sorter("aaaa"),is("aaaa"));
		assertThat(ss.sorter("aabb"),is("aabb"));
	}
	
	// 소문자 a-z 숫자 0-9 이외의 문자가 포함되어 있을 경우 UnExpectedInputException 라는 사용자정의 런타임 예외 발생
	@Test(expected=UnExpectedInputException.class)
	public void inputValidTest() {
		assertThat(ss.sorter("11#11"),is("11#11"));
	}
	
	// a-z 까지만 뽑아내는 메서드 테스트
	@Test
	public void alphabetExtractTest() {
		
		assertThat(ss.alphaExt("a6g3b"),is("agb"));
		assertThat(ss.alphaExt("a6g3b").length(),is(3) );
	}
	
	// 0-9 까지만 뽑아내는 메서드 테스트
	@Test
	public void numberExtractTest() {
			
		assertThat(ss.numberExt("a6g3b"),is("63"));
		assertThat(ss.numberExt("a6g3b").length(),is(2) );
	}
	
	
	// 영어만 있을 때와 숫자만 있을 때 정렬되는 메서드 테스트
	@Test
	public void sortTest() {
		assertThat(ss.sort("bfsaa"),is("aabfs"));
		assertThat(ss.sort("23034"),is("02334"));
	}
	
	// 영어 만 있을때 숫자만 있을때 정렬 되는지  sorter메서드 테스트
		@Test
		public void sorterTest1() {
			assertThat(ss.sort("bfsaa"),is("aabfs"));
			assertThat(ss.sort("23034"),is("02334"));
		}
	
	// 영어 따로 추출, 숫자 따로 추출하고 따로 정렬 한 다음 번갈아가면서 추가 ( 한쪽이 없을땐 건너 뜀 )
	@Test
	public void sorterTest() {
		assertThat(ss.sorter("aaa019a"),is("a0a1a9a"));
		assertThat(ss.sorter("abz09"),is("a0b9z"));
		assertThat(ss.sorter("abzcc"),is("abccz"));
		assertThat(ss.sorter("09019"),is("00199"));
		assertThat(ss.sorter("aaaaa0"),is("a0aaaa"));
	}
	

}
