-- Atualizando registros existentes
update candidato
set situacao = 'AGUARDANDO'
where situacao IS NULL;