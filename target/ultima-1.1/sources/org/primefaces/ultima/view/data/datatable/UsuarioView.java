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

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.ultima.domain.Car;
import org.primefaces.ultima.domain.Usuario;
import org.primefaces.ultima.service.CarService;
import org.primefaces.ultima.service.UsuarioService;

@ManagedBean(name="dtUsuarioView")
@ViewScoped
public class UsuarioView implements Serializable {

    private List<Usuario> usuarios;

    @ManagedProperty("#{usuarioService}")
    private UsuarioService service;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setService(UsuarioService service) {
        this.service = service;
    }
}