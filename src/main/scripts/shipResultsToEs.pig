-- this script is an exilirily script to compibe the data results from (pricePredictor.pig) and join it to the initail set
-- To Run the script
-- pig -x local -f shipResultsToEs.pig -param filename=file.csv
REGISTER '../../../target/lottery-1.0.0.jar';
define AddDelim com.stats.util.SequenceUDF;
--REGISTER '../../../lib/elasticsearch-hadoop-pig.jar';
--define EsStorage org.elasticsearch.hadoop.pig.EsStorage('es.resource=test/seq');

data = load '$filename' as (line);
d = foreach data generate AddDelim(line);

words = foreach d generate flatten(TOKENIZE($0)) as word;
-- Now group them together by each word.
grpd = group words by word;
-- Count them.
cntd = foreach grpd generate group, COUNT(words);
-- Print out the results.
dump cntd;
--store results into 'test/seq' USING EsStorage('es.http.timeout = 5m      es.index.auto.create = false');