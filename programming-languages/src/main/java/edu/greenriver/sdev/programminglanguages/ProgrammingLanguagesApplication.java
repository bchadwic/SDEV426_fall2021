package edu.greenriver.sdev.programminglanguages;

import edu.greenriver.sdev.programminglanguages.db.IFrameworkRepository;
import edu.greenriver.sdev.programminglanguages.db.ILanguageRepository;
import edu.greenriver.sdev.programminglanguages.model.Framework;
import edu.greenriver.sdev.programminglanguages.model.Language;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProgrammingLanguagesApplication
{
    public static void main(String[] args)
    {
        //get my spring container
        ApplicationContext context = SpringApplication.run(ProgrammingLanguagesApplication.class, args);

        //ask the spring container for a spring bean (our data layer)
        ILanguageRepository langRepo = context.getBean(ILanguageRepository.class);
        IFrameworkRepository frameRepo = context.getBean(IFrameworkRepository.class);

        //add a few DB objects
        Language[] languages = {
            Language.builder().name("C#").ranking(1).looselyTyped(false).build(),
            Language.builder().name("Java").ranking(3).looselyTyped(false).build(),
            Language.builder().name("Javascript").ranking(2).looselyTyped(true).build(),
            Language.builder().name("PHP").ranking(6).looselyTyped(true).build(),
            Language.builder().name("Python").ranking(4).looselyTyped(true).build(),
            Language.builder().name("C++").ranking(5).looselyTyped(false).build()
        };

        Framework[] frameworks = {
            Framework.builder().name("Fat-Free").ranking(5).language("PHP").build(),
            Framework.builder().name("Django").ranking(4).language("Python").build(),
            Framework.builder().name("Ruby on Rails").ranking(3).language("Ruby").build(),
            Framework.builder().name("Spring").ranking(1).language("Java").build(),
            Framework.builder().name("React").ranking(2).language("Javascript").build(),
        };

        for (Language language : languages)
        {
            //persist this Language object to the database
            langRepo.save(language);
        }
        System.out.println("All languages saved to DB");

        frameRepo.saveAll(Arrays.asList(frameworks));
        System.out.println("All frameworks saved to DB");
    }
}
