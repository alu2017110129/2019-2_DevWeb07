<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="WebOcorrencias.Views.Shared.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div style="height: 134px; font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif; font-size: xx-large; font-weight: bold; font-style: normal; color: #0000FF; width: auto; top: auto; font-variant: normal; bottom: inherit;">
            <asp:Image ID="Image1" runat="server" Height="130px" ImageUrl="~/Models/Images/Connect_With_Us_Icon.jpg" Width="140px" ImageAlign="Middle" />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Cadastro de Clientes</div>
        <br />
        <asp:RadioButton ID="RadioButton1" runat="server" OnCheckedChanged="RadioButton1_CheckedChanged" Text="Incluir" Width="82px" />
        <asp:RadioButton ID="RadioButton2" runat="server" Text="Alterar" Width="82px" />
        <asp:RadioButton ID="RadioButton3" runat="server" OnCheckedChanged="RadioButton3_CheckedChanged" Text="Excluir" Width="83px" />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Código&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Técnico<br />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="TextBox5" runat="server" Height="30px" Width="97px"></asp:TextBox>
&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="TextBox6" runat="server" Height="30px" Width="138px" style="margin-left: 0px"></asp:TextBox>
        &nbsp;&nbsp;&nbsp;
        <asp:Image ID="Image2" runat="server" Height="180px" Width="180px" />
        <br />
        Nome / Razão Social<br />
            <asp:TextBox ID="Nome" runat="server" Height="30px" Width="536px"></asp:TextBox>
        &nbsp;
        <br />
        CEP&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Endereço (Rua, Av...)<br />
        <asp:TextBox ID="TextBox1" runat="server" Height="30px" Width="97px"></asp:TextBox>
&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="TextBox2" runat="server" Height="30px" Width="404px" style="margin-left: 0px"></asp:TextBox>
        <br />
        Número&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Complemento&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Bairro&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br />
        <asp:TextBox ID="TextBox7" runat="server" Height="30px" Width="82px"></asp:TextBox>
&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="TextBox8" runat="server" Height="30px" Width="129px"></asp:TextBox>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="TextBox3" runat="server" Height="30px" Width="256px"></asp:TextBox>
&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="Button1" runat="server" Height="35px" OnClick="Button1_Click" Text="Procura Foto" Width="180px" />
        <br />
    </form>
</body>
</html>
