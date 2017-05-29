package com.mdy.java.dateformat;

import java.text.SimpleDateFormat;
import java.util.Date;

class DateFormatExam
{
  public static void main(String[] args)
  {
    Date today = new Date();

    SimpleDateFormat sdf0 = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yy�� MM�� dd�� E����");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
    SimpleDateFormat sdf5 = new SimpleDateFormat("������ �� ���� D��° ���Դϴ�.");
    SimpleDateFormat sdf6 = new SimpleDateFormat("������ �� ���� d��° ���Դϴ�.");
    SimpleDateFormat sdf7 = new SimpleDateFormat("������ �� ���� w��° ���Դϴ�.");
    SimpleDateFormat sdf8 = new SimpleDateFormat("������ �� ���� W��° ���Դϴ�.");
    SimpleDateFormat sdf9 = new SimpleDateFormat("������ �� ���� F��° E�����Դϴ�.");

    System.out.println(sdf0.format(today));
    System.out.println(sdf1.format(today));
    System.out.println(sdf2.format(today));
    System.out.println(sdf3.format(today));
    System.out.println(sdf4.format(today));
    System.out.println(sdf5.format(today));
    System.out.println(sdf6.format(today));
    System.out.println(sdf7.format(today));
    System.out.println(sdf8.format(today));
    System.out.println(sdf9.format(today));
  }
}