package com.espacocliente.defaultParameters;

import com.espacocliente.utils.GeneralUtils;

public class GlobalStaticParameters {
    //UserParameters
    public static String USUARIO = "testeind01@teste.com";
    public static String CODCARTEIRA1 = "00063627009486007";
    public static String CODCARTEIRADEPENDENTE = "00063627009486309";
    public static int CODCLIENTEORIGEM = 473;
    public static int CODCANALAOL = 6;

    //BuscaDadosCliente
    public static long cod_TipoUsuario = 5;

    //BuscaParaQualEspecialidade
    public static long cod_SeqLocalidadeSelecionada = 2754;
    public static long CodTipoProfissional = 1;
    public static long cod_TipoAtendimento = 2;

    //BuscaListaAgendamentos
    public static boolean retornaHistorico = true;

    //ExecutaPesquisaHorarios
    public static Integer CodRetornarFoto = 0;
    public static Integer TipoPesquisa = 1;
    public static Integer CodCartao = 0;
    public static Double LatitudePessoa = -19.9402225;
    public static Double LongitudePessoa = -43.9125442;
    public static Integer IDPrograma = -1;
    public static Integer RaioPesquisa = 20000;
    public static String DataInicioAtendimento = GeneralUtils.getNowDate("yyyy-MM-dd'T'HH:mm:ssZ");
    public static String DataInicioAtendimentoHour = GeneralUtils.getNextHourDate("yyyy-MM-dd'T'HH:mm:ssZ", 24);
    public static String DataInicioAtendimentoRetroativa = "2020-03-18-00-00-00";
    public static String DataFinalAtendimento = GeneralUtils.getNextMonthDate("yyyy-MM-dd'T'HH:mm:ssZ");
    public static Integer CodLocalClinica = -1;
    public static Integer TamanhoPaginaHorariosDisp = 10;
    public static Integer TamanhoPaginaHorariosIndisp = 10;
    public static Integer NumeroPaginaHorariosIndisp = 1;
    public static Integer NumeroPaginaHorariosDisp = 1;
    public static String DesTipoAtendimento = "Consulta";
    public static Integer CodEspecialidade = 77;
    public static Integer CodEspecialidade2 = 74;
    public static Integer CodEspecialidade3 = 97;
    public static Integer CodEspecialidade4 = 102;
    public static String DesEspecialidade = "Dermatologia";
    public static String DesEspecialidade2 = "Clinica Medica";
    public static String DesEspecialidade3 = "Oftalmologia";
    public static String DesEspecialidade4 = "Pediatria";
    public static Integer CodSubEspecialidade = -1;
    public static Integer CodSubEspecialidade2 = 121;
    public static String DesSubEspecialidade = "OFTALMOLOGIA GERAL";
    public static Integer RetornaIndisponiveis = 0;
    public static String NomeProfissionalPediatria = "Antonio Augusto Nunes Leao";
    public static String NomeProfissional = "LICIANA";
    public static Integer CodTurnoTarde = 2;
    public static Integer ValorOpcaoOndeBH = 2754;

    //ConfirmaAgendamentoBuscaDados
    public static String ExecutarWSTipoAtendimento = "True";
    //public Integer codProfissional = 33753;
    public static String DesTipoPrifissional = "Médico";
    public static String HoraInicioAtendimento = "00:00:00";
    public static String HoraFinalAtendimento = "23:59:59";
    public static Integer CodConvenioIntercambio = -1;

    //ConfirmaAgendamento
    public static Integer NumDDDFixo = 31;
    public static Integer NumTelFixo = 12345678;
    public static Integer NumCelFixo = 999998888;
    public static Integer CodTipoTelFixo = 1;
    public static Integer NumDDDCelular = 31;
    public static Boolean AceiteMensagemConfirmacao = true;
    public static Boolean ConfirmaAlertaPreMarcacao = true;
    public static String MensagemConfirmacaoAgendamento = "Seu horário foi marcado com sucesso.";

    //Localização
    public static Integer IdOpcaoOndeOutraCidade = 6;
    public static Integer IdOpcaoOnde = 7;
    public static String SexoMedico = "F";
    public static Integer CodLocalClinicaStEfigenia = 45451;

    //Transcrição
    public static String descricaoTranscricao = "TRANSCRIÇÃO REALIZADA POR AUTOMAÇÃO DE TESTES";
    public static String nomeContato = "O PRÓPRIO";
    public static String nomeContatoPessoa = "Leonardo Pessoa Machado";
    public static String telContato = "3132237608";
    public static String celContato = "31975620246";
    public static String codigoCanalAtendimento = "ECL";
    public static String tipoParentesco = "X";
    public static String tipoParentescoDependente = "J";
    public static Integer identificadorPessoa = 259945;
    public static String nomeOperador = "ECL UNIMEDBH";
    public static String dataT = GeneralUtils.getNowDate("yyyy-MM-dd'T'HH:mm:ssZ");
    public static String tipoTranscricao = "Transcricao";
    public static Integer idTipoDocDigitalizado = 117;
    public static String descricaoTipoConteudo = "image/jpeg";
    public static String descricaoDocDigitalizado = "imagemTeste.png";
    public static String descricaoDocDigitalizado2 = "imagemTeste2.png";
    public static String observacaoDocDigitalizado = "TRANSCRIÇÃO REALIZADA POR AUTOMAÇÃO DE TESTES";
    public static String nomeOrigemDocumentoDigital = "CALLCENTER_PENDENCIA";
    public static Integer totalParteArquivo = 1;
    public static Integer numeroParteAtual = 1;
    public static Integer idGrupoDocDigitalizado = 9;
    public static String emailDependente = "wilmarasalomao@yahoo.com.br";
    public static Integer IdentificadorDependente = 2380281;
    public static Integer numTelefoneFixoDependente = 40204020;
    public static Integer numTelefoneCelularDependente = 991781788;
    public static String emailPessoaOutraCarteira = "neocandeias1@gmail.com";
    public static String nomeContatoPessoaOutraCarteira = "Nardeli Eunice Oliveira Candeias";
    public static String pessoaOutraCarteira = "00063627065704006";
    public static Integer identificadorPessoaOutraCarteira = 504713;
    public static String carteiraIncorreta = "23456465465";

    //Authenticate
    public static String uri = "ldapService";

    //Reembolso
    public static String tipoConta = "C";
    public static String banco = "246";
    public static String agencia = "1234";
    public static String conta = "1234561";
    public static String valorTotalSolicitado = "100.00";
    public static String cpfTitular = "85084697649";
    public static String tipoSolicitacao = "REEMBOLSO";
    public static String origemInformacao = "PORTAL";
    public static String descricaoReembolso = "REEMBOLSO REALIZADO POR AUTOMAÇÃO DE TESTES";
    public static String numTelefoneCelular = "32125500";
    public static String dddTelefoneCelular = "31";
    public static String dddTelefoneContato = "31";
    public static String numTelefoneContato = "99998888";
    public static Integer idGrupoDocDigitalizadoReembolso = 19;
    public static String nomeOrigemDocumentoDigitalReembolso = "PROCESSO_CACR";
    public static Integer idTipoDocDigitalizadoReembolso = 89;
    public static String usuarioConsultaReembolso = "suporte";
    public static String senhaConsultaReembolso = "bert";
    public static Integer encription = 0;
}