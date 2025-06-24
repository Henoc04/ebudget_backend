#!/bin/sh

# Script d'attente d'un service TCP (host:port)
# Usage : ./wait-for.sh host:port -- commande à exécuter ensuite

hostport="$1"
shift

host=$(echo $hostport | cut -d: -f1)
port=$(echo $hostport | cut -d: -f2)

echo "⏳ Attente de $host:$port..."

while ! nc -z $host $port; do
  sleep 2
done

echo "✅ $host:$port est accessible. Lancement de l'application..."
exec "$@"
