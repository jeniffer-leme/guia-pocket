# 🗺️ Guia Pocket - Bairro X

## 📱 Descrição
O **Guia Pocket - Bairro X** é um aplicativo Android desenvolvido em **Kotlin** que tem como objetivo **divulgar pequenos serviços e comércios locais** do bairro X, como lanchonetes, costureiras, oficinas, barbearias e outros empreendimentos da região.  

O app oferece uma **experiência simples, funcional e visualmente atrativa**, permitindo que o usuário:
- 📋 Consulte uma lista de estabelecimentos em **RecyclerView**;  
- 🔍 Visualize detalhes sobre cada serviço;  
- 📞 Utilize funcionalidades nativas, como **fazer ligações** ou **abrir o site** do estabelecimento;  
- 🌗 Alterne entre **modo claro e escuro**;  
- 🌎 Escolha o idioma entre **português e inglês**;  
- ➕ Adicione novos locais via **CadastroActivity**;  
- 🖼️ Armazene imagens como **URI** no banco usando **Room**;  
- 🔍 Filtre os locais por nome em tempo real na tela principal.

---

## 📸 Visualização (Screenshots)

### ☀️ Modo Claro (Português)
<p align="left">
  &nbsp;&nbsp;&nbsp;<img src="https://github.com/jeniffer-leme/guia-pocket/blob/main/img/capa_modo-claro.png?raw=true" width="200"/>
  &nbsp;&nbsp;&nbsp;<img src="https://github.com/jeniffer-leme/guia-pocket/blob/main/img/lista_modo-claro.png?raw=true" width="200"/>
  &nbsp;&nbsp;&nbsp;<img src="https://github.com/jeniffer-leme/guia-pocket/blob/main/img/estabelecimento_modo-claro.png?raw=true" width="200"/>
  &nbsp;&nbsp;&nbsp;<img src="https://github.com/jeniffer-leme/guia-pocket/blob/main/img/cadastro_modo-claro.png?raw=true" width="200"/>
</p>

### 🌙 Modo Escuro (Português)
<p align="left">
  &nbsp;&nbsp;&nbsp;<img src="https://github.com/jeniffer-leme/guia-pocket/blob/main/img/capa_modo-escuro.png?raw=true" width="200"/>
  &nbsp;&nbsp;&nbsp;<img src="https://github.com/jeniffer-leme/guia-pocket/blob/main/img/lista_modo-escuro.png?raw=true" width="200"/>
  &nbsp;&nbsp;&nbsp;<img src="https://github.com/jeniffer-leme/guia-pocket/blob/main/img/estabelecimento_modo-escuro.png?raw=true" width="200"/>
  &nbsp;&nbsp;&nbsp;<img src="https://github.com/jeniffer-leme/guia-pocket/blob/main/img/cadastro_modo-escuro.png?raw=true" width="200"/>
</p>

### 🇬🇧 English Mode (Light)
<p align="left">
  &nbsp;&nbsp;&nbsp;<img src="https://github.com/jeniffer-leme/guia-pocket/blob/main/img/capa_modo-ingles.png?raw=true" width="200"/>
  &nbsp;&nbsp;&nbsp;<img src="https://github.com/jeniffer-leme/guia-pocket/blob/main/img/lista_modo-ingles.png?raw=true" width="200"/>
  &nbsp;&nbsp;&nbsp;<img src="https://github.com/jeniffer-leme/guia-pocket/blob/main/img/estabelecimento_modo-ingles.png?raw=true" width="200"/>
  &nbsp;&nbsp;&nbsp;<img src="https://github.com/jeniffer-leme/guia-pocket/blob/main/img/cadastro_modo-ingles.png?raw=true" width="200"/>
</p>

---

## 🎥 Demonstração em Vídeo
📹 **[Clique Aqui - Demonstração do App](https://github.com/jeniffer-leme/guia-pocket/blob/main/img/video_app.webm)**

## 🎬 Apresentação em Vídeo
Assista à demonstração completa do aplicativo, suas funcionalidades e implementação técnica!

➡️ **[ASSISTA AQUI NO YOUTUBE](https://www.youtube.com/watch?v=OfESKiAcayE)** ⬅️

---

## 🧩 Funcionalidades
- Exibição de lista de comércios e serviços locais em **RecyclerView**  
- Tela de detalhes com informações específicas (nome, categoria, descrição, endereço, telefone, imagem)  
- **Filtro em tempo real** na lista de locais por nome  
- Tela de cadastro para **adicionar novos locais** (CadastroActivity)  
- Suporte a **modo dia/noite (DayNight Theme)**  
- **Internacionalização (i18n)** — suporte multilíngue (português / inglês)  
- Uso de **ViewBinding** para acesso seguro às views  
- Persistência de dados usando **Room**, armazenando imagens via **URI**  
- Implementação de **Adapter personalizado** para exibir os itens da lista  
- **Intents explícitas e implícitas** para ações do sistema (chamadas, sites etc.)

---

## 🛠️ Tecnologias utilizadas
- **Linguagem:** Kotlin  
- **IDE:** Android Studio  
- **Interface:** XML + ViewBinding  
- **Componentes principais:** RecyclerView, Adapter, Intents  
- **Persistência:** Room (SQLite)  
- **Internacionalização:** Strings traduzidas (pt / en)  
- **Tema:** DayNight (modo claro/escuro automático)

---

## 🚀 Como executar o projeto
1. Clone este repositório:  
   ```bash
   git clone https://github.com/jeniffer-leme/guia-pocket.git
