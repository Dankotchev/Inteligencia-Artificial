# TRABALHO

- Criar um Sistema Especialista com pelo menos 30 regras de produção. O tema é livre para deixar essa tarefa mais interessante. 
- Não haverá análise em relação ao tema, desde que haja bom senso. Também não haverá discussão se o Sistema Especialista desenvolvido cobre todos os pontos do tema, pois estamos simulando o Sistema Especialista, não haverá implantação real.
- A única restrição formal é o número mínimo de regras. Portanto, não há restrições em relação ao número de variáveis, objetivos e perguntas. 
- Lembre que as variáveis devem englobar o conjunto de regras esperadas, os objetivos devem ser claros e alcançáveis e as perguntas devem ir norteando o caminho para a solução.
- Entregue dois arquivos, um com as regras escritas e um .bcm, a ser aberto pelo Expert Sinta, que contém todo o Sistema Especialista.


# SINAPE - Sistema Inteligente de Escolha de Pets

## Objetivo

O SINEPE tem como objetivo ser um auxílio na escolha do pet ideal para as suas necessidades seja financeira, sociais ou de espaços.
Os animais que o sistema infere ao usuário são: *Gato, Cachorro de pequeno porte, Cachorro de médio porte, Cachorro de grande porte, Peixe, Coelho, Hamster, Pássaros, Galinha, Cavalo, Alpaca, Tartaruga, Iguana, Furão*.

## Regras

Regra 1:<br>
SE vive em família<br>
E possui crianças<br>
ENTÃO animais para crianças como pet.<br>
Fator de Confiança: 90%<br>

Regra 2:<br>
SE vive em família<br>
E não possui crianças<br>
ENTÃO animal de companhia como pet<br>
Fator de Confiança: 60%<br>

Regra 3:<br>
SE pessoa idosa:<br>
ENTÃO animal de companhia como pet.<br>
Fator de Confiança: 80%<br>

Regra 4:<br>
SE é alérgico a pelos<br>
ENTÃO animais peludos não é opção.<br>
Fator de Confiança: 100%<br>

Regra 5:<br>
SE não é alérgico a pelos<br>
ENTÃO animais peludos é opção.<br>
Fator de Confiança: 100%<br>


Regra 6:<br>
SE tipo de residência é apartamento espaçoso<br>
OU tipo da residência é casa<br>
OU tipo de residência é chácara<br>
ENTÃO animais grandes como pet.<br>
Fator de Confiança: 90%<br>

Regra 7:<br>
SE tipo da residência é apartamento pequeno<br>
OU tipo de residência é apartamento espaçoso<br>
OU tipo da residência é casa<br>
OU tipo da residência é chácara<br>
ENTÃO animais pequenos como pet.<br>
Fator de Confiança: 90%<br>

Regra 8:<br>
SE tipo da residência é casa<br>
OU tipo de residência é apartamento espaçoso<br>
OU tipo de residência é apartamento pequeno<br>
ENTÃO animais de fazenda não são opção.<br>
Fator de Confiança: 90%<br>

Regra 9:<br>
SE tipo residência é chácara<br>
ENTÃO animais de fazenda são opção.<br>
Fator de Confiança: 100%<br>

Regra 10:<br>
SE tipo residência é apartamento espaçoso<br>
OU tipo residência é apartamento pequeno<br>
E condomínio possui regras<br>
ENTÃO silêncio é prioridade<br>
Fator de Confiança: 70%<br>

Regra 11:<br>
SE há tempo disponível para cuidados<br>
E animais de fazenda são opção<br>
E busca algo diferente<br>
E possui orçamento<br>
ENTÃO Alpaca como pet.<br>
Fator de Confiança: 80%<br>

Regra 12:<br>
SE não há tempo disponíveis para cuidados<br>
E animais pequenos como pet<br>
E animais peludos não é opção<br>
E busca algo diferente<br>
ENTÃO Tartaruga como pet.<br>
Fator de Confiança: 80%<br>

Regra 13:<br>
SE há tempo disponível para cuidados<br>
E animais de fazenda são opção<br>
E não busca algo diferente<br>
E possui orçamento<br>
ENTÃO Cavalo como pet.<br>
Fator de Confiança: 100%<br>

Regra 14:<br>
SE há tempo disponível para cuidados<br>
E animais de fazenda são uma opção<br>
ENTÃO Galinha como pet.<br>
Fator de Confiança: 100%<br>

Regra 15:<br>
SE animais pequenos como pet<br>
E não há tempo disponível para cuidados<br>
E animais peludos não é opção<br>
E silêncio é prioridade<br>
ENTÃO Peixe como pet.<br>
Fator de Confiança: 90%<br>

Regra 16:<br>
SE animais pequenos como pet<br>
E há tempo disponível para cuidados<br>
E animais peludos é opção<br>
E silêncio é prioridade<br>
ENTÃO Coelho como pet.<br>
Fator de Confiança: 90%<br>

Regra 17:<br>
SE animais pequenos como pet<br>
E não há tempo disponível para cuidados<br>
E animais peludos é opção<br>
ENTÃO Hamster como pet.<br>
Fator de Confiança: 70%<br>

Regra 18:<br>
SE animais pequenos como pet<br>
E estilo de vida calmo<br>
E silêncio é prioridade<br>
E animais peludos é opção<br>
ENTÃO Gato como pet.<br>
Fator de Confiança: 90%<br>

Regra 19:<br>
SE animais pequenos como pet<br>
E estilo de vida agitado<br>
E silêncio é prioridade<br>
ENTÃO Cachorro de pequeno porte como pet.<br>
Fator de Confiança: 90%<br>

Regra 20:<br>
SE animais pequenos como pet<br>
E estilo de vida calmo<br>
E silêncio não é prioridade<br>
ENTÃO Cachorro de pequeno porte como pet.<br>
Fator de Confiança: 90%<br>

Regra 21:<br>
SE animais de companhia como pet<br>
E animais pequenos como pet<br>
E animais peludos é opção<br>
E silêncio é prioridade<br>
ENTÃO Coelho como pet.<br>
Fator de Confiança: 80%<br>

Regra 22:<br>
SE animais de companhia como pet<br>
E animais pequenos como pet<br>
E busca algo diferente<br>
ENTÃO Pássaros como pet.<br>
Fator de Confiança: 90%<br>

Regra 23:<br>
SE animais para crianças como pet<br>
E animais pequenos como pet<br>
E animais peludos são opção<br>
ENTÃO cachorro de médio porte como pet.<br>
Fator de Confiança: 80%<br>

Regra 24:<br>
SE animais para crianças como pet<br>
E animais pequenos como pet<br>
E animais peludos não são opção<br>
ENTÃO Peixe como pet.<br>
Fator de Confiança: 90%<br>

Regra 25:<br>
SE animais para crianças como pet<br>
E animais de companhia como pet<br>
E animais peludos são opção<br>
ENTÃO Gato como pet.<br>
Fator de Confiança: 100%<br>

Regra 26:<br>
SE animais para crianças como pet<br>
E animais grandes como pet<br>
E animais peludos são opção<br>
E estilo de vida agitado<br>
ENTÃO Cachorro de grande porte como pet.<br>
Fator de Confiança: 90%<br>

Regra 27:<br>
SE animais para crianças como pet<br>
E animais peludos são opção<br>
E estilo de vida calmo<br>
OU animais pequenos como pet<br>
ENTÃO Hamster como pet.<br>
Fator de Confiança: 60%<br>

Regra 28:<br>
SE animais grandes como pet<br>
E possui orçamento<br>
OU busca algo diferente<br>
ENTÃO Iguana como pet.<br>
Fator de Confiança: 100%<br>

Regra 29:<br>
SE animais pequenos como pet<br>
E silêncio não é prioridade<br>
E animais peludos não é opção<br>
E busca algo diferente<br>
ENTÃO Galinha como pet.<br>
Fator de Confiança: 80%<br>

Regra 30:<br>
SE animais grandes como pet<br>
E estilo de vida agitado<br>
ENTÃO Cachorro de grande porte como pet.<br>
Fator de Confiança: 80%<br>

Regra 31:<br>
SE animais grandes como pet<br>
E não possui orçamento<br>
E não busca algo diferente<br>
ENTÃO Cachorro de grande porte como pet.<br>
Fator de Confiança: 100%<br>

Regra 32:<br>
SE animais pequenos como pet<br>
E animais peludos é opção<br>
E possui orçamento<br>
E busca algo diferente<br>
E há tempo disponível<br>
ENTÃO Furão como pet.<br>
Fator de Confiança: 70%