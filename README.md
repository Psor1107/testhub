# TestHub-DSW1

Uma aplicação web projetada para auxiliar testadores de jogos no gerenciamento de suas sessões de testes. Construído utilizando Java Servlets, JSP, and Maven.

![TestHub Logo](https://i.imgur.com/KRbg32p.png "TestHub")

---

## Como rodar localmente

- **Clonar o repositório**:

```bash
   git clone https://github.com/Psor1107/testhub.git
   cd testhub
```

- **Compilar com o maven**:

```bash
    ./mvnw clean install
```

- **Abrir e rodar o tomcat**
- **Banco de dados:**

  - Baixar e extrair o Apache Derby
  - Conectar-se ao banco de dados, criar testhub

  ```bash
      java -jar derbyrun.jar ij
      connect 'jdbc:derby:testhub;create=true';
  ```

  - Executar o script de criação do banco de dados

  ```bash
    ij> run 'path-usuario\testhub\esquema.sql';
  ```

- **Deploy no tomcat utilizando o Maven Plugin**

```bash
    ./mvnw tomcat7:deploy
```

- **Acessar o sistema:**
  http://localhost:8080/testhub/

## Current State

We are currently focused on implementing the core requirements. Below is a visual representation of the current progress:

![Current State Diagram](https://www.plantuml.com/plantuml/dpng/fPB1QkCm48RlVWgTT_5XhoQ46CS1GxAxR19OUYbJUKYdM58hZQ0qpGFrEVfYbHNRjKieXPwY-Vy_CvyqNZW6orurYMp0ER5t7YmPSKo4-2cepiJQw4Cij56OYIrRwWHKG4slYAFNzE3n52s7-XQ6y2dfkkUr8YsEfwxSeMEqRTsFdJsdwJaraRfat-QlDNV8NuEiqKbB4inK1OR24aHzRIGqIs3SaS9eArGtrhXWaUDPHp9_lySMdGCJeIv11Dq2uu4W4-LmZXQZkZSRqfxRzgJv4qZ7mDu5AVwUPmxqbIP9b-2ZkoBrmHhWHqJVU41y31TfZ9j6GyoDjuxQgmb-d5Zyg_Bbdt0eDzVb_xBO5tbRhQhV-Rgw2bRxr_EdagRpOTkPEA15BGFtZwGNGs2oZKn8e_drHOLCLEo5I82NdjisOptanc-J2S_Kq1E8NoEOIK123Q5k6orGrrurRm00 "Current State")

## Principais Funcionalidades

- **Gerenciamento de Estratégias de Teste:**
  - Cadastro de sessões de teste (requer login de testador)
- **Gerenciamento de Sessões de Teste Exploratório:**
  - Cadastro de sessões vinculadas a projetos, testadores (usuário logado), estratégias, com tempo definido e descrição
  - Controle do ciclo de vida da sessão: Criado -> Em Execução (com registro de bugs)
- O sistema deve ser internacionalizado em pelo menos dois idiomas: português e inglês.

---

## Future Plans

Our next steps involve integrating the database and implementing key functionalities.

### Planning

The following diagram outlines our vision for the final project structure and functionality:

![Future Planning Diagram](https://www.plantuml.com/plantuml/dpng/fLJBRjim4BpxAuXSqWTywDL8WZ2AaWgGxS2oYw2NO2Cjb2r4qkN329hcQtee-XtviLAq7XQg5W6QGoJD3cTdrYJFZGLjdQWcn-mq_B4evLaMP-ncbIoYv8OdMLEPJF8AZ64Ruq2JOayJnjupAcOiLR8C7r89dB7CQce0541LYx0d9-chm-TGCYWVe2C_j-gy42GRxQsc7LLOakeaJjdHrIPDxtWKnLbsrAzRex6ecuMITbZ5ZrlKX38dE5oUBDRnQXvV9doLB0y4Ff4X2z9Yq3Xc6Ge6pgAqbCFBpvSVYhsHzVy7r0Mm0jj1lAqrsg6SV9zEzna6K6ElxNMZrHUqhnjXWIRNte8Qec0XqWG1JrKErILON9F0K1OexhKolaJ6dZHEpkfOmPjXs3Wo_G0oD0PKWCUCULo3nRAUPjozXv95iLLpaixMBKdQVnWt5gmp7WhFVSykKI8ffx50eNf5Ognqxyesw8Khp_f0lSl_63G--d2LCaEgfmqH4b2YR7qazPSuiB87ncpa84W-37jMwBMAaSFXyurfMBAkKgy8KshOKG653txTlexyAhvDttE55LZrbmEVAsdH5N_kpMlKOtlJgtONJRpOpBkx1QKJWpqHkaMhX5yk_KiylujlusWJyVhhAbdmDFdiIrumBEtZX7KNFBdb_XcEkN_oTCqxQfSnKFb5l5e7qJZws2Xs5bTnogDakU3pUB5UTcRtTzHqUjOTv1ahKOUhXhsRjA0d30xLB8phvPVmd83e4Ge-OkviBNE01vvtxEiQIp9MZn7w_Uvvpb95tu1zcFHmO3LRSSQsoXX7NgUv-SPKTcGSU9snTlt62EbzgtumGvKS2cWydwCidAX-0m00 "Future Planning")

---

Stay tuned for updates as we continue to build and refine TestHub! 😺👍
