package business.impl;

import business.CoachService;
import dataAccess.CoachDao;
import model.Coach;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CoachServiceImplTest {
    @InjectMocks
    private CoachService coachService = CoachServiceImpl.getInstance();
    @Mock
    private CoachDao coachDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculSalaireHebdomadaire() {
        when(coachDao.nbHeuresCoachingUtilisees(12345)).thenReturn(5);
        Coach coach = new Coach(1, "NomCoachTest", "PrenomCoachTest", null, 11, new Date());
        when(coachDao.obtentionCoach(12345)).thenReturn(coach);
        double salaire = coachService.calculSalaireHebdomadaire(12345);
        assertEquals(55, salaire, 0.1);
    }
}