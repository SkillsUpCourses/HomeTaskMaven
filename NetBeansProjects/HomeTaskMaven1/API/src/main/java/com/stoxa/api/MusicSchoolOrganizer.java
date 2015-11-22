/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.api;

import java.util.List;

/**
 *
 * @author stoxa
 */
public interface MusicSchoolOrganizer {

    void addNewStudent(Student student,SchoolClass cshoolClass);
    void deleteStudentFromClass(Student student,SchoolClass cshoolClass);
    List <Student> getAllStudents();
    List<Student> getStudentsFromClass (SchoolClass cshoolClass);
   
}
