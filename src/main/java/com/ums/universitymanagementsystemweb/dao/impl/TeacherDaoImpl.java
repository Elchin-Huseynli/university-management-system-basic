package com.ums.universitymanagementsystemweb.dao.impl;

import com.ums.universitymanagementsystemweb.config.DataBaseConfig;
import com.ums.universitymanagementsystemweb.dao.TeacherDao;
import com.ums.universitymanagementsystemweb.model.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static com.ums.universitymanagementsystemweb.queries.TeacherQuery.*;

public class TeacherDaoImpl extends DataBaseConfig implements TeacherDao {

    @Override
    public List<Teacher> findTeachers() {
        List<Teacher> teachers = new LinkedList<>();
        try (Connection connection = getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_TEACHERS);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String subject = resultSet.getString("subject");

                Teacher teacher = Teacher.builder()
                        .id(id)
                        .name(name)
                        .email(email)
                        .subject(subject)
                        .build();

                teachers.add(teacher);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teachers;
    }

    @Override
    public boolean createTeacher(Teacher teacher) {
        try (Connection connection = getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TEACHER);
            preparedStatement.setString(1,teacher.getName());
            preparedStatement.setString(2,teacher.getEmail());
            preparedStatement.setString(3,teacher.getSubject());

            int val = preparedStatement.executeUpdate();
            return val>0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        try (Connection connection = getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TEACHER);
            preparedStatement.setString(1,teacher.getName());
            preparedStatement.setString(2,teacher.getEmail());
            preparedStatement.setString(3,teacher.getSubject());
            preparedStatement.setLong(4,teacher.getId());

            int val = preparedStatement.executeUpdate();
            return val>0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteTeacher(Long id) {
        try (Connection connection = getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TEACHER);
            preparedStatement.setLong(1,id);

            int val = preparedStatement.executeUpdate();
            return val>0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Teacher findByIdTeacher(Long id) {
        try (Connection connection = getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_TEACHER);
            preparedStatement.setLong(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            Long id1 = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String subject = resultSet.getString("subject");

            return Teacher.builder()
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
    public Teacher searchTeacher() {
        return null;
    }

}
