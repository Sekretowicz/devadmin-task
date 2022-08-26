package com.example.devadmintask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class NativeQueryService {
    @Autowired
    private EntityManager em;

    @Transactional
    public String query(String queryString) {

        System.out.println("SELECT QUERY");

        String response = new String();

        //For SELECT query we should return a table
        if (Pattern.compile("SELECT .*", Pattern.CASE_INSENSITIVE).matcher(queryString).matches()) {

            List<Object[]> list = em.createNativeQuery(queryString).getResultList();
            for (Object[] row : list) {
                for (int i = 0; i < row.length; i++) {
                    response += row[i].toString();

                    if (i == row.length - 1) {
                        response += ";\n";
                    } else {
                        response += ", ";
                    }
                }
            }        }
        else {
            response = String.valueOf(em.createNativeQuery(queryString).executeUpdate());
        }

        return response;

    }
}
