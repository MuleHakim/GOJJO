package com.Gojjo.house.request;

import java.util.List;
import java.util.Optional;

// import com.gojjo.gojjo_app.Request;
// import com.gojjo.gojjo_app.RequestRepository;
// import com.gojjo.gojjo_app.RequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RequestServiceHandler implements RequestService{
    
    @Autowired
    private RequestRepository  repo;

    @Override
    public List<Request> findAllRequests() {
    
        return  repo.findAll();
    }

    

    @Override
    public void SaveRequest(Request request) {
        repo.save(request);
        
    }



    @Override
    public void deleteRequest(Long id) {
       
        repo.deleteById(id);
    }



    @Override
    public Request findRequestById(Long id) {
        Optional<Request> requestResponse = repo.findById(id);
        Request request = null;
        if(requestResponse.isPresent()){
            request = requestResponse.get();
        }else{
            throw new RuntimeException(" The request you are looking for does not exist.");
        }
        return request;
     
    }

    // @Override
    // public List<Request> getAllById() {
        
    // return  repo.findAll();
    // }
    // @Override
    // public void save(Request request) {
    //     repo.save(request);

    // @Override
    // public Object findAll() {
    
    //     return repo.findAll();
    // }
        
    // }
    // @Override
    // public void save(Request request) {
    //     
        
    // }



    
}
