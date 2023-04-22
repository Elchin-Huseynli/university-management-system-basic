package com.ums.universitymanagementsystemweb.dao.impl;

import com.ums.universitymanagementsystemweb.config.DataBaseConfig;
import com.ums.universitymanagementsystemweb.dao.StudentDao;
import com.ums.universitymanagementsystemweb.model.Student;
import static com.ums.universitymanagementsystemweb.queries.StudentQuery.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StudentDaoImpl extends DataBaseConfig implements StudentDao {
    @Override
    public List<Student> findStudents() {
        List<Student> students = new LinkedList<>();
        try (Connection connection = getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_STUDENTS);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String subject = resultSet.getString("subject");

                Student student = Student.builder()
                        .id(id)
                        .name(name)
                        .email(email)
                        .subject(subject)
                        .build();

                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public boolean createStudent(Student student) {
        try (Connection connection = getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_STUDENT);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setString(3,student.getSubject());

            int val = preparedStatement.executeUpdate();
            return val>0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        try (Connection connection = getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setString(3,student.getSubject());
            preparedStatement.setLong(4,student.getId());

            int val = preparedStatement.executeUpdate();
            return val>0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteStudent(Long id) {
        try (Connection connection = getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setLong(1,id);

            int val = preparedStatement.executeUpdate();
            return val>0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Student findByIdStudent(Long id) {
        try (Connection connection = getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_STUDENT);
            preparedStatement.setLong(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            Long id1 = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String subject = resultSet.getString("subject");

            return Student.builder()
                    .id(id1)
                    .name(name)
                    .email(email)
                    .subject(subject)
                    .build();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Student searchStudent() {
        return null;
    }
}
