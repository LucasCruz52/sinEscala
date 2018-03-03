package org.primefaces.ultima.domain;

import java.util.List;

public class ExigenciasLegais {

    public static boolean atendeExigenciasLegaisPreferencia(int idBlocoHorarioPreferencia, int idprofissional){

        boolean atendeExigencias = false;

        BlocoHorarioPreferencia blocoHorarioPreferencia =  null; //Recuperar do banco pelo idBlocoHorarioPreferencia
        Profissional profissional = null; //Recuperar do banco pelo idProfissional
        PreferenciaDiaria preferenciaDiaria = null; //Recuperar do banco pelo BlocoHorarioPrefencia.idPreferenciaDiaria

        boolean profissionalJaAlocadoNoDia = false;
        boolean intervaloDescansoDesrespeitado = false;

        Restricao restricaoProfissional = profissional.getCargaHorariaDiaria().getRestricao();

        List<PreferenciaDiaria> alocacoesMensaisProfissional = null; //Recuperar do banco pelo idProfissional e BlocoHorarioPrefencia.idPreferenciaDiaria

        int quantidadeHorasProfissional = profissional.getHorario().getCargaHorariaDiaria().getDuracao();
        int diaPretendido = preferenciaDiaria.getDia();

        //Se carga horária for de 6 horas
        if(quantidadeHorasProfissional == 6){

            for (int i = 0; i < alocacoesMensaisProfissional.size(); i++) {

                if(alocacoesMensaisProfissional.get(i).getDia() == diaPretendido){
                    profissionalJaAlocadoNoDia = true;
                }

            }

            //Se carga horária for de 12 horas
        }else if(quantidadeHorasProfissional == 12){

            if(diaPretendido > 2) {
                for (int i = 0; i < alocacoesMensaisProfissional.size(); i++) {

                    //Se o profissional já está alocado para aquele dia
                    if (alocacoesMensaisProfissional.get(i).getDia() == diaPretendido) {
                        profissionalJaAlocadoNoDia = true;
                        //Se o profissional já está alocado para o dia anterior
                    } else if (alocacoesMensaisProfissional.get(i).getDia() == diaPretendido + 1) {
                        intervaloDescansoDesrespeitado = true;
                    }

                }
            }else{
                //Recuperar PrefenciaDiaria do ultimo dia mês anterior pelo BlocoHorarioPrefencia.idPreferenciaDiaria
                PreferenciaDiaria preferenciaDiariaMesAnterior = null;

                if(preferenciaDiariaMesAnterior.getBlocosHorarioPreferencia().get(0).getEnfermeirosAlocados().get(0).getId() == profissional.getId()){
                    intervaloDescansoDesrespeitado = true;
                }
            }
        }

        if(profissionalJaAlocadoNoDia || intervaloDescansoDesrespeitado){
            atendeExigencias = false;
        }

        return  atendeExigencias;

    }

}
