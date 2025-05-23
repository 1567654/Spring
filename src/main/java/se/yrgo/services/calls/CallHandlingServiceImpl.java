package se.yrgo.services.calls;

import se.yrgo.domain.Action;
import se.yrgo.domain.Call;
import se.yrgo.services.customers.CustomerManagementMockImpl;
import se.yrgo.services.customers.CustomerManagementService;
import se.yrgo.services.customers.CustomerNotFoundException;
import se.yrgo.services.diary.DiaryManagementService;
import se.yrgo.services.diary.DiaryManagementServiceMockImpl;

import java.util.Collection;

public class CallHandlingServiceImpl implements CallHandlingService {
    CustomerManagementService customerService;
    DiaryManagementService diaryService;

    public CallHandlingServiceImpl(CustomerManagementMockImpl customerManagementMock, DiaryManagementServiceMockImpl diaryManagementServiceMock) {
        customerService = customerManagementMock;
        diaryService = diaryManagementServiceMock;
    }

    @Override
    public void recordCall(String customerId, Call newCall, Collection<Action> actions) throws CustomerNotFoundException {
        customerService.recordCall(customerId, newCall);
        for (Action action : actions) {
            diaryService.recordAction(action);
        }
    }
}
