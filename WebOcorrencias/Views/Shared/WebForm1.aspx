<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="WebOcorrencias.Views.Shared.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div style="height: 134px; font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif; font-size: x-large; font-weight: bold; font-style: normal; color: #0000FF;">
            <asp:Image ID="Image1" runat="server" Height="130px" ImageUrl="~/Models/Images/Connect_With_Us_Icon.jpg" Width="130px" />
            Registro de Ocorrências<br />
            <br />
        </div>
        <br />
        <asp:RadioButton ID="RadioButton1" runat="server" OnCheckedChanged="RadioButton1_CheckedChanged" Text="Incluir" />
        <asp:RadioButton ID="RadioButton2" runat="server" Text="Alterar" />
        <asp:RadioButton ID="RadioButton3" runat="server" OnCheckedChanged="RadioButton3_CheckedChanged" Text="Excluir" />
        <br />
        <br />
        Nome / Razão Social<p>
            <asp:TextBox ID="Nome" runat="server" Height="30px" Width="354px"></asp:TextBox>
        </p>
    </form>
</body>
</html>
