package com.Gojjo.house.request;

import java.util.List;

import org.springframework.stereotype.Service;
@Service

public interface RequestService {


    List<Request> findAllRequests();
    void SaveRequest(Request request);
    void deleteRequest(Long id);

    public Request findRequestById(Long id);
    // public List<Request> getAllById();
    // public void save(Request request);
    
}
