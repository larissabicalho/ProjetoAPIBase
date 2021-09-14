public class CriarUsuarioRequest extends RequestRestBase {
    public PostCriarUsuarioRequest() {
        requestService = "/api/rest/users/";
        method = Method.POST;
        headers.put("Authorization", "wgGoYvqRl2f-iAYzz4TPW5EiqkRvyFNI");
    }

    public void setJsonBodyUsingJavaObject(CriarUsuario criarUsuario) {
        jsonBody = criarUsuario;
    }

}