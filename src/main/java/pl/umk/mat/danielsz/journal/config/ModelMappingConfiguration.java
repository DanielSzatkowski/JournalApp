package pl.umk.mat.danielsz.journal.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.umk.mat.danielsz.journal.model.User;

@Configuration
public class ModelMappingConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);

        modelMapper.addMappings(new PropertyMap<User, User>() {
            @Override
            protected void configure(){
                skip().setEntries(null);
            }
        });

        return modelMapper;
    }
}
