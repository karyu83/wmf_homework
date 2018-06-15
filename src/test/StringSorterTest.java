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
	
	// Ŭ���� �ʱ�ȭ
	@Before
	public void setUp(){
		this.ss = new StringSorter();
	}
	
	// �Էµ� ���ڿ� �״�� ��ȯ �������� ���� �׽�Ʈ
	@Test
	public void inputTest() {
		
		assertThat(ss.sorter("1111"),is("1111"));
		assertThat(ss.sorter("aaaa"),is("aaaa"));
		assertThat(ss.sorter("aabb"),is("aabb"));
	}
	
	// �ҹ��� a-z ���� 0-9 �̿��� ���ڰ� ���ԵǾ� ���� ��� UnExpectedInputException ��� ��������� ��Ÿ�� ���� �߻�
	@Test(expected=UnExpectedInputException.class)
	public void inputValidTest() {
		assertThat(ss.sorter("11#11"),is("11#11"));
	}
	
	// a-z ������ �̾Ƴ��� �޼��� �׽�Ʈ
	@Test
	public void alphabetExtractTest() {
		
		assertThat(ss.alphaExt("a6g3b"),is("agb"));
		assertThat(ss.alphaExt("a6g3b").length(),is(3) );
	}
	
	// 0-9 ������ �̾Ƴ��� �޼��� �׽�Ʈ
	@Test
	public void numberExtractTest() {
			
		assertThat(ss.numberExt("a6g3b"),is("63"));
		assertThat(ss.numberExt("a6g3b").length(),is(2) );
	}
	
	
	// ��� ���� ���� ���ڸ� ���� �� ���ĵǴ� �޼��� �׽�Ʈ
	@Test
	public void sortTest() {
		assertThat(ss.sort("bfsaa"),is("aabfs"));
		assertThat(ss.sort("23034"),is("02334"));
	}
	
	// ���� �� ������ ���ڸ� ������ ���� �Ǵ���  sorter�޼��� �׽�Ʈ
		@Test
		public void sorterTest1() {
			assertThat(ss.sort("bfsaa"),is("aabfs"));
			assertThat(ss.sort("23034"),is("02334"));
		}
	
	// ���� ���� ����, ���� ���� �����ϰ� ���� ���� �� ���� �����ư��鼭 �߰� ( ������ ������ �ǳ� �� )
	@Test
	public void sorterTest() {
		assertThat(ss.sorter("aaa019a"),is("a0a1a9a"));
		assertThat(ss.sorter("abz09"),is("a0b9z"));
		assertThat(ss.sorter("abzcc"),is("abccz"));
		assertThat(ss.sorter("09019"),is("00199"));
		assertThat(ss.sorter("aaaaa0"),is("a0aaaa"));
	}
	

}
