package edu.greenriver.sdev.programminglanguages.services;

import edu.greenriver.sdev.programminglanguages.db.IFrameworkRepository;
import edu.greenriver.sdev.programminglanguages.model.Framework;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class FrameworkService
{
    private IFrameworkRepository repo;

    public FrameworkService(IFrameworkRepository repo)
    {
        this.repo = repo;
    }

    public List<Framework> allFrameworks()
    {
        return repo.findAll();
    }

    public Framework random()
    {
        List<Framework> all = repo.findAll();
        Random random = new Random();
        Framework randFrame = all.get(random.nextInt(all.size()));

        return randFrame;
    }

    public List<Framework> topThree()
    {
        List<Framework> all = repo.findAll();
        List<Framework> top3 = all.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());

        return top3;
    }

    public Framework frameworkByRank(int rank)
    {
        return repo.findByRankingIs(rank);
    }

    public Framework frameworkById(int id){
        return new Framework();
    }

    public Framework favorite(){
        return repo.findByRankingIs(1);
    }
}
