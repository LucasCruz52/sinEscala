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
package org.primefaces.ultima.view.data.datatable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.ultima.domain.Stats;
import org.primefaces.ultima.domain.Team;

@ManagedBean(name="dtSubTableView")
public class SubTableView {
    
    private List<Team> teams;

    @PostConstruct
    public void init() {
        teams = new ArrayList<Team>();
        Team lakers = new Team("Los Angeles Lakers");
        lakers.getStats().add(new Stats("2005-2006", 50, 32));
        lakers.getStats().add(new Stats("2006-2007", 44, 38));
        lakers.getStats().add(new Stats("2007-2008", 40, 42));
        //lakers.getStats().add(new Stats("2008-2009", 45, 37));
        //lakers.getStats().add(new Stats("2009-2010", 48, 34));
        //lakers.getStats().add(new Stats("2010-2011", 42, 42));
        teams.add(lakers);
        
        Team celtics = new Team("Boston Celtics");
        celtics.getStats().add(new Stats("2005-2006", 46, 36));
        celtics.getStats().add(new Stats("2006-2007", 50, 32));
        celtics.getStats().add(new Stats("2007-2008", 41, 41));
        //celtics.getStats().add(new Stats("2008-2009", 45, 37));
        //celtics.getStats().add(new Stats("2009-2010", 38, 44));
        //celtics.getStats().add(new Stats("2010-2011", 35, 47));
        teams.add(celtics);

        Team teste = new Team("Teste");
        teste.getStats().add(new Stats("2005-2006", 46, 36));
        teste.getStats().add(new Stats("2006-2007", 50, 32));
        teste.getStats().add(new Stats("2007-2008", 41, 41));
        //celtics.getStats().add(new Stats("2008-2009", 45, 37));
        //celtics.getStats().add(new Stats("2009-2010", 38, 44));
        //celtics.getStats().add(new Stats("2010-2011", 35, 47));
        teams.add(teste);

        Team teste2 = new Team("Teste");
        teste2.getStats().add(new Stats("2005-2006", 46, 36));
        teste2.getStats().add(new Stats("2006-2007", 50, 32));
        teste2.getStats().add(new Stats("2007-2008", 41, 41));
        //celtics.getStats().add(new Stats("2008-2009", 45, 37));
        //celtics.getStats().add(new Stats("2009-2010", 38, 44));
        //celtics.getStats().add(new Stats("2010-2011", 35, 47));
        teams.add(teste2);
    }
    
    public List<Team> getTeams() {
        return teams;
    }
}
