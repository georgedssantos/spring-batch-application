package com.example.batchprocessing.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.batchprocessing.model.Person;
import com.example.batchprocessing.processor.PersonItemProcessor;
import com.example.batchprocessing.reader.PersonItemReader;
import com.example.batchprocessing.writer.PersonItemWriter;

@Configuration
//@EnableBatchProcessing //ANOTAÇÃO PARA CONFIGURAÇÃO DE JOBS BEANS NECESSÁRIOS PARA O PROCESSAMENTO EM LOTE.
public class BatchConfig {
	
    @Autowired
	private PersonItemReader personItemReader;
    
    @Autowired
    private PersonItemProcessor personItemProcessor;
    
    @Autowired
    private PersonItemWriter personItemWriter;
	    
    @Bean
    public Job runJob(JobRepository jobRepository, @Qualifier("stepPerson") Step stepPerson) {
        return new JobBuilder("runJob", jobRepository)
            .start(stepPerson)
            .build();
    }
    

    @Bean
    public Step stepPerson(JobRepository jobRepository , PlatformTransactionManager transactionManage) {
        var step = new StepBuilder("stepPerson", jobRepository)
                .<Person,Person>chunk(10 , transactionManage) // DEFINIÇÃO DO TAMANHO DO CHUNK
                //.reader(personItemReader.reader())
                .reader(personItemReader.csvReader())
                .processor(personItemProcessor)
                .writer(personItemWriter)
                .build();
        return step;
    }
           
}
