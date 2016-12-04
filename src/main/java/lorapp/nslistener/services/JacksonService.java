package lorapp.nslistener.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JacksonService {

	private ObjectMapper mapper;
	
	public JacksonService() {
		mapper = new ObjectMapper();
	}
	
	public String toJsonString(Object o) throws JsonProcessingException {
		return mapper.writeValueAsString(o);
	}
	
	public <T> T toObject(String str, Class<T> clazz) {
		try {
			return mapper.readValue(str, clazz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
