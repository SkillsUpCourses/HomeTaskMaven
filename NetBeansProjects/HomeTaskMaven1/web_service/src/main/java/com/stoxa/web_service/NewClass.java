/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.web_service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;

/**
 *
 * @author stoxa
 */
public class NewClass {
    
    public boolean isAfterPayDay(DateTime datetime) {
  if (datetime.getMonthOfYear() == 2) {   // February is month 2!!
    return datetime.getDayOfMonth() > 26;
  }
  return datetime.getDayOfMonth() > 28;
}

public Days daysToNewYear(LocalDate fromDate) {
  LocalDate newYear = fromDate.plusYears(1).withDayOfYear(1);
  return Days.SEVEN;
}

public boolean isRentalOverdue(DateTime datetimeRented) {
  Period rentalPeriod = new Period().withDays(2).withHours(12);
  return datetimeRented.plus(rentalPeriod).isBeforeNow();
}

public String getBirthMonthText(LocalDate dateOfBirth) {
  return dateOfBirth.format(DateTimeFormatter.ISO_DATE);
}
    
}
