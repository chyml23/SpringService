package com.example.demo.converter.impl;

import com.example.demo.converter.BusinessUserConverter;
import com.example.demo.model.Education;
import com.example.demo.model.mockoon.AdditionalInfo;
import com.example.demo.model.mockoon.BusinessUserConverted;
import com.example.demo.model.postman.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BusinessUserConverterImpl implements BusinessUserConverter {
    @Override
    public BusinessUserConverted convert(User user) {
        BusinessUserConverted businessUserConverted = new BusinessUserConverted();
        businessUserConverted.setUuid(user.getId());
        businessUserConverted.setName(user.getName());
        businessUserConverted.setBirthYear(LocalDate.now().getYear() - user.getAge());
        businessUserConverted.setHomeAdress(user.getAdress());

        AdditionalInfo educationInfo = new AdditionalInfo();
        educationInfo.setType("Education");
        educationInfo.setName(user.getEducation().getUniversity());
        educationInfo.setEndDate(user.getEducation().getGraduationDate());

        AdditionalInfo workInfo = new AdditionalInfo();
        workInfo.setType("lastWork");
        workInfo.setName(user.getWorkInfo().getOrganizationName());
        workInfo.setEndDate(user.getWorkInfo().getEndDate());

        List<AdditionalInfo> additionalInfo =  new ArrayList<>();
        Collections.addAll(additionalInfo, workInfo, educationInfo);
        businessUserConverted.setAdditionalInfo(additionalInfo);

        return businessUserConverted;
    }
}
