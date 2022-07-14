package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MostUsedCharacterTest {
    @Test
    public void getMaxCount() {
        String str = "���� ���� ����";
        char rsl = MostUsedCharacter.getMaxCount(str);
        char expected = '�';
        assertThat(rsl, is(expected));
    }

    @Test
    public void getMaxCount1() {
        String ln = System.lineSeparator();
        String str = "��� ���� ����� ������� ������ "
                + "����� �� � ����� ������� "
                + "�� ������� ���� �������� "
                + "� ����� �������� �� ��� "
                + "��� ������ ������ ����� "
                + "�� ���� ��� ����� ����� "
                + "� ������� ������ � ���� � ���� "
                + "�� ������ �� ���� ����� "
                + "����� ������ ��������� "
                + "���������� ��������� "
                + "��� ������� ���������� "
                + "�������� ��������� ��������� "
                + "�������� � ������ ��� ���� "
                + "����� �� ���� ������� ����";
        char rsl = MostUsedCharacter.getMaxCount(str);
        char expected = '�';
        assertThat(rsl, is(expected));
    }
}