/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.ultima.view.data;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@ManagedBean
@ViewScoped
public class ScheduleView implements Serializable {

	private static Locale locale = new Locale("pt_Br");

	private ScheduleModel eventModel;
	
	private ScheduleModel lazyEventModel;

	private ScheduleEvent event = new DefaultScheduleEvent();

    @PostConstruct
	public void init() {
		eventModel = new DefaultScheduleModel();
		for (int i = 0; i < 31; i++) {
		    if(i!=2 && i!=3 && i!=9 && i!=10 && i!=16 && i!=17 && i!=23 && i!=24 && i!=30) {
                DefaultScheduleEvent evento1 = new DefaultScheduleEvent("Lucas Mateus de Santana Cruz", exactDayHour(i + 1, 2, 1, 7, 0), exactDayHour(i + 1, 2, 2, 1, 0));
                evento1.setStyleClass("manha");
                evento1.setEditable(false);
                eventModel.addEvent(evento1);
            }else{
                DefaultScheduleEvent evento1 = new DefaultScheduleEvent("Lucas Mateus de Santana Cruz", exactDayHour(i + 1, 2, 2, 7, 0), exactDayHour(i + 2, 2, 1, 7, 0));
                evento1.setStyleClass("feriado");
                evento1.setEditable(false);
                eventModel.addEvent(evento1);
            }
            //DefaultScheduleEvent evento2 = new DefaultScheduleEvent("Allan Silva Santos", exactDayHour(i+1, 2, 1, 7, 0), exactDayHour(i+1, 2, 2, 1, 0));
            //evento2.setStyleClass("manha");
            //eventModel.addEvent(evento2);
            //DefaultScheduleEvent evento3 = new DefaultScheduleEvent("Pablo Lima", exactDayHour(i+1, 2, 1, 7, 0), exactDayHour(i+1, 2, 2, 1, 0));
            //evento3.setStyleClass("manha");
            //eventModel.addEvent(evento3);
            //DefaultScheduleEvent evento4 = new DefaultScheduleEvent("Enfermeiro 1", exactDayHour(i+1, 2, 1, 7, 0), exactDayHour(i+1, 2, 2, 1, 0));
            //evento4.setStyleClass("manha");
            //eventModel.addEvent(evento4);
            //DefaultScheduleEvent evento5 = new DefaultScheduleEvent("Técnico 1", exactDayHour(i+1, 2, 1, 7, 0), exactDayHour(i+1, 2, 2, 1, 0));
            //evento5.setStyleClass("manha");
            //eventModel.addEvent(evento5);
        }

        for (int i = 0; i < 31; i++) {
            //DefaultScheduleEvent evento1 = new DefaultScheduleEvent("Lucas Mateus de Santana Cruz", exactDayHour(i + 1, 2, 2, 1, 0), exactDayHour(i + 1, 2, 2, 7, 0));
            //evento1.setStyleClass("tarde");
            //eventModel.addEvent(evento1);
            //DefaultScheduleEvent evento2 = new DefaultScheduleEvent("Allan Silva Santos", exactDayHour(i+1, 2, 2, 1, 0), exactDayHour(i+1, 2, 2, 7, 0));
            //evento2.setStyleClass("tarde");
            //eventModel.addEvent(evento2);
            //DefaultScheduleEvent evento3 = new DefaultScheduleEvent("Pablo Lima", exactDayHour(i+1, 2, 2, 1, 0), exactDayHour(i+1, 2, 2, 7, 0));
            //evento3.setStyleClass("tarde");
            //eventModel.addEvent(evento3);
        }

        for (int i = 0; i < 31; i++) {
            //DefaultScheduleEvent evento1 = new DefaultScheduleEvent("Lucas Mateus de Santana Cruz", exactDayHour(i + 1, 2, 2, 7, 0), exactDayHour(i + 2, 2, 1, 7, 0));
            //evento1.setStyleClass("noite");
            //eventModel.addEvent(evento1);
            //DefaultScheduleEvent evento2 = new DefaultScheduleEvent("Allan Silva Santos", exactDayHour(i+1, 2, 2, 7, 0), exactDayHour(i+2, 2, 1, 7, 0));
            //evento2.setStyleClass("noite");
            //eventModel.addEvent(evento2);
            //DefaultScheduleEvent evento3 = new DefaultScheduleEvent("Pablo Lima", exactDayHour(i+1, 2, 2, 7, 0), exactDayHour(i+2, 2, 1, 7, 0));
            //evento3.setStyleClass("noite");
            //eventModel.addEvent(evento3);
            //DefaultScheduleEvent evento4 = new DefaultScheduleEvent("Enfermeio 1", exactDayHour(i+1, 2, 2, 7, 0), exactDayHour(i+2, 2, 1, 7, 0));
            //evento4.setStyleClass("noite");
            //eventModel.addEvent(evento4);
            //DefaultScheduleEvent evento5 = new DefaultScheduleEvent("Técnico 1", exactDayHour(i+1, 2, 2, 7, 0), exactDayHour(i+2, 2, 1, 7, 0));
            //evento5.setStyleClass("noite");
            //eventModel.addEvent(evento5);
        }
		
		lazyEventModel = new LazyScheduleModel() {
			
			@Override
			public void loadEvents(Date start, Date end) {
				Date random = getRandomDate(start);
				addEvent(new DefaultScheduleEvent("Lazy Event 1", random, random));
				
				random = getRandomDate(start);
				addEvent(new DefaultScheduleEvent("Lazy Event 2", random, random));
			}	
		};
	}
	
	public Date getRandomDate(Date base) {
		Calendar date = Calendar.getInstance();
		date.setTime(base);
		date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);	//set random day of month
		
		return date.getTime();
	}
	
	public Date getInitialDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
		
		return calendar.getTime();
	}
	
	public ScheduleModel getEventModel() {
		return eventModel;
	}
	
	public ScheduleModel getLazyEventModel() {
		return lazyEventModel;
	}

	private Calendar today() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar;
	}

	private Date exactDayHour(int day, int month, int pmAm, int hour, int minute){
        Calendar t = (Calendar) today().clone();

        t.set(Calendar.MONTH, month);
        t.set(Calendar.DAY_OF_MONTH, day);

        if(pmAm == 1) {
            t.set(Calendar.AM_PM, Calendar.AM);
        }else {
            t.set(Calendar.AM_PM, Calendar.PM);
        }

        t.set(Calendar.HOUR, hour);
        t.set(Calendar.MINUTE, minute);

        return t.getTime();
    }
	
	private Date previousDay8Pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
		t.set(Calendar.HOUR, 8);
		
		return t.getTime();
	}
	
	private Date previousDay11Pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
		t.set(Calendar.HOUR, 11);
		
		return t.getTime();
	}
	
	private Date today1Pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 1);
		
		return t.getTime();
	}

    private Date today6Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.HOUR, 6);

        return t.getTime();
    }
	
	private Date theDayAfter3Pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);		
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		
		return t.getTime();
	}

	private Date today6Pm() {
		Calendar t = (Calendar) today().clone(); 
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 6);
		
		return t.getTime();
	}
	
	private Date nextDay9Am() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.AM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
		t.set(Calendar.HOUR, 9);
		
		return t.getTime();
	}
	
	private Date nextDay11Am() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.AM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
		t.set(Calendar.HOUR, 11);
		
		return t.getTime();
	}
	
	private Date fourDaysLater3pm() {
		Calendar t = (Calendar) today().clone(); 
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
		t.set(Calendar.HOUR, 3);
		
		return t.getTime();
	}
	
	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}
	
	public void addEvent(ActionEvent actionEvent) {
		if(event.getId() == null)
			eventModel.addEvent(event);
		else
			eventModel.updateEvent(event);
		
		event = new DefaultScheduleEvent();
	}
	
	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}
	
	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}
	
	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
		
		addMessage(message);
	}
	
	public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
		
		addMessage(message);
	}
	
	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
