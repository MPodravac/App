package com.example.matejapodravac.myapplication.listeners;

import com.example.matejapodravac.myapplication.models.Person;
import com.example.matejapodravac.myapplication.models.Subject;

public interface SummaryInfoDataSource {
    Person getPerson();
    Subject getSubject();
}
