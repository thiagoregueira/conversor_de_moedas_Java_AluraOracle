# Conversor de Moedas

## Descrição do Projeto
O Conversor de Moedas é um programa em Java que permite ao usuário converter valores entre diferentes moedas. O programa usa a API Extended Rate para obter as taxas de câmbio em tempo real. Projeto do curso Oracle Next Education + Alura: Challange conversor de moedas.

## Características
- Conversão de moedas em tempo real usando a API Extended Rate.
- Suporta a conversão entre dólar americano e as seguintes moedas:
  - Real brasileiro
  - Iene japonês
  - Euro
  - Dólar australiano
  - Dólar canadense
  - Libra esterlina

## Como usar
1. Execute o programa.
2. Selecione a opção de conversão desejada no menu.
3. Digite o valor que deseja converter.
4. O programa exibirá o valor convertido.

## Configuração
Para usar este programa, você precisa ter uma chave de API válida para a API Extended Rate. Para obter a sua chave, você precisa fazer um registro inicial digitando seu e-mail. Depois disso, você receberá uma chave no e-mail fornecido e estará pronta para uso.

Depois de obter a chave da API, adicione-a ao seu arquivo `.env` na raiz do projeto da seguinte maneira:
```API_KEY=sua_chave_api```
