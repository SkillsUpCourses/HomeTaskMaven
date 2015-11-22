/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.web_service;

import com.stoxa.api.MusicSchoolOrganizer;
import com.stoxa.api.SchoolClass;
import com.stoxa.api.Student;
import java.util.List;

/**
 *
 * @author stoxa
 */
public class REST implements MusicSchoolOrganizer {

    @Override
    public void addNewStudent(Student student, SchoolClass cshoolClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteStudentFromClass(Student student, SchoolClass cshoolClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> getAllStudents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> getStudentsFromClass(SchoolClass cshoolClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
