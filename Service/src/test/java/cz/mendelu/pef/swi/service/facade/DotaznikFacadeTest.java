/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.service.facade;

import cz.mendelu.pef.swi.api.dto.DotaznikDTO;
import cz.mendelu.pef.swi.api.facade.DotaznikFacade;
import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import cz.mendelu.pef.swi.service.service.config.ServiceConfiguration;
import cz.mendelu.pef.swi.service.services.BeanMappingService;
import cz.mendelu.pef.swi.service.services.DotaznikService;
import cz.mendelu.pef.swi.service.services.OdpovedService;
import cz.mendelu.pef.swi.service.services.UzivatelService;
import java.util.Collection;
import static org.hibernate.internal.util.collections.ArrayHelper.toList;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Martin
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class DotaznikFacadeTest extends AbstractTestNGSpringContextTests{
    @Mock
    DotaznikService dotaznikServiceMock;
    
    @Mock
    private UzivatelService uzivatelService;
  
    @Mock
    private OdpovedService OdpovedService;
  
    
    @Mock
    private BeanMappingService beanMappingServiceMock;
    
    @InjectMocks
    DotaznikFacade dotaznikFacade = new DotaznikFacadeImpl();
    
    private Dotaznik dotaznik1;
    private Dotaznik dotaznik2;
    
    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        dotaznik1 = new Dotaznik("Mega dotaznik", "mega tema","Co", 1);
        dotaznik2 = new Dotaznik("Ultra dotaznik", "mega tema","NaCo", 1);
    }
    
    @Test
    public void testFindAllTrainersFacade() throws Exception {
        DotaznikDTO dto1 = new DotaznikDTO();
        DotaznikDTO dto2 = new DotaznikDTO();

        doReturn(toList(new Dotaznik[]{dotaznik1, dotaznik2})).when(dotaznikServiceMock).findAll();
        doReturn(toList(new DotaznikDTO[]{dto1, dto2})).when(beanMappingServiceMock)
                .mapTo(Matchers.anyListOf(Dotaznik.class), (Class<?>) Matchers.any(Class.class));

        Collection<DotaznikDTO> dotaznikDTOs = dotaznikFacade.getAllDotaznik();
        Assert.assertEquals(dotaznikDTOs.size(), 2);

        verify(dotaznikServiceMock).findAll();
        verifyNoMoreInteractions(dotaznikServiceMock);
    }
    
      @Test
    public void testGetTrainerByIdFacade() throws Exception {
        DotaznikDTO dto = new DotaznikDTO();
        dto.setId(1);

        doReturn(dotaznik1).when(dotaznikServiceMock).findById(1);
        doReturn(dto).when(beanMappingServiceMock).mapTo(Matchers.any(Dotaznik.class),
                (Class<?>) Matchers.any(Class.class));

        DotaznikDTO trainerDTO = dotaznikFacade.getDotaznikWithId(1);
        Assert.assertEquals(trainerDTO.getId(), 1);

        verify(dotaznikServiceMock).findById(1);
        verify(beanMappingServiceMock).mapTo(dotaznik1, DotaznikDTO.class);
        verifyNoMoreInteractions(dotaznikServiceMock);
}
}
